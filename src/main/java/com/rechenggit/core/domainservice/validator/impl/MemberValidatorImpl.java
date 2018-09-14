package com.rechenggit.core.domainservice.validator.impl;

import com.netfinworks.common.lang.StringUtil;
import com.rechenggit.core.dal.dataobject.Member;
import com.rechenggit.core.domain.enums.MemberStatusEnum;
import com.rechenggit.core.domain.BaseMember;
import com.rechenggit.core.domain.MemberIntegratedQuery;
import com.rechenggit.core.domain.enums.ResponseCode;
import com.rechenggit.core.domainservice.repository.MemberRepository;
import com.rechenggit.core.domainservice.validator.MemberValidator;
import com.rechenggit.core.exception.MaBizException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.rechenggit.core.domain.enums.MemberStatusEnum.NORMAL;

@Service
public class MemberValidatorImpl  implements MemberValidator {
    @Autowired
    MemberRepository memberRepository;
    @Override
    public Member validateMemberExistAndNormal(String identity, Integer platFormType) throws MaBizException {
        MemberIntegratedQuery query = new MemberIntegratedQuery();
        query.setMemberIdentity(StringUtil.toLowerCase(StringUtil.trim(identity)));
        query.setPlatformType(platFormType);
        query.setRequireAccountInfos(false);
        query.setRequireVerifyInfos(false);
        Member m= memberRepository.queryBaseMember(query);
        if (m == null) {
            throw new MaBizException(ResponseCode.MEMBER_NOT_EXIST, "会员identity为" + identity
                    + "的会员不存在");
        }
        checkMemberStatus(m);
        return m;
    }

    /**
     * 验证会员状态
     * @param m
     * @throws MaBizException
     */
    public void checkMemberStatus(Member m) throws MaBizException {
        switch (MemberStatusEnum.getByCode(m.getStatus())) {
            case NORMAL:
                break;
            case CANCEL:
                throw new MaBizException(ResponseCode.MEMBER_CANCELLED, "会员编号为" + m.getMemberId()
                        + "的会员已注销。");
            case SLEEP:
                throw new MaBizException(ResponseCode.MEMBER_SLEEP, "会员编号为" + m.getMemberId()
                        + "的会员已休眠。");
            case UNACTIVE:
                throw new MaBizException(ResponseCode.MEMBER_UNACTIVE, "会员编号为" + m.getMemberId()
                        + "的会员未激活。");
            default:
                break;
        }
    }
}
