package com.rechenggit.core.domainservice.validator.impl;

import com.netfinworks.common.lang.StringUtil;
import com.rechenggit.core.dal.dataobject.Operator;
import com.rechenggit.core.domain.enums.OperatorStatusEnum;
import com.rechenggit.core.domain.enums.ResponseCode;
import com.rechenggit.core.domainservice.repository.OperatorRepository;
import com.rechenggit.core.domainservice.validator.OperatorValidator;
import com.rechenggit.core.exception.MaBizException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OperatorValidatorImpl implements OperatorValidator {
    @Autowired
    OperatorRepository operatorRepository;
    @Override
    public Operator validateOperatorExistAndNormal(String memberId, String loginName, Integer platFormType)throws MaBizException {
        String operatorId = operatorRepository.queryOperatorIdByLoginName(memberId,
                StringUtil.toLowerCase(StringUtil.trim(loginName)), platFormType);
        if (null == operatorId) {
            throw new MaBizException(ResponseCode.LOGIN_NAME_NOT_EXIST);
        }
        Operator operator = operatorRepository.loadByOperatorId(operatorId);
        if (null == operator) {
            throw new MaBizException(ResponseCode.OPERATOR_NOT_EXIST);
        }
        validateOperatorStatus(operator);

        return operator;
    }

    @Override
    public void validateLoginPassWord(String password) throws MaBizException {
        //判断登陆密码是否存在
        if (StringUtil.isBlank(password)) {
            throw new MaBizException(ResponseCode.LOGIN_PASSWORD_NOT_EXISTS);
        }
    }
    /**
     * 验证操作员状态，非正常都抛异常
     * @param operatorStatus
     * @throws MaBizException
     */
    private void validateOperatorStatus(Operator operator) throws MaBizException {
        switch (OperatorStatusEnum.getByCode(operator.getStatus())) {
            case UNACTIVE:
                throw new MaBizException(ResponseCode.OPERATOR_UNACTIVE, "operatorId为"
                        + operator.getOperatorId()
                        + "的操作员未激活");
            case CANCEL:
                throw new MaBizException(ResponseCode.OPERATOR_CANCEL, "operatorId为"
                        + operator.getOperatorId()
                        + "的操作员已注销");
            default:
                break;
        }
    }
}
