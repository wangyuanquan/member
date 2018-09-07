package com.rechenggit.core.domainservice.repository;

import com.rechenggit.core.domain.AccountDomain;
import com.rechenggit.core.domain.enums.AccountCategoryEnum;
import com.rechenggit.core.exception.MaBizException;

import java.util.List;

public interface AccountRepository {

    /**
     * 账户关系持久化
     * @param account
     */
    void store(AccountDomain account);

    /**
     * 账户关系持久化
     * <li>memberId+accountType+accountName唯一并作幂等</li>
     * @param account
     */
    void storeForUpdate(AccountDomain account) throws MaBizException;

    /**
     * 更新账户关系，并清除缓存（memberId ,memberId+单个账户类型）
     * @param account
     * @param cacheKeys 
     * @throws MaBizException
     */
    void reStore(AccountDomain account, List<String> cacheKeys) throws MaBizException;

    /**
     * 更新基本户，并激活会员
     * @param account
     */
    void reStoreBaseAccount(AccountDomain account) throws MaBizException;

    /**
     * 查询会员账户关系，不使用缓存
     * @param memberId
     * @param accountTypes
     * @return
     */
    List<AccountDomain> getAccounts(String memberId, List<Long> accountTypes);
    
    /**
     * 
     * @param memberId
     * @param accountTypes
     * @param catEnum
     * @return
     */
    List<AccountDomain> getAccounts(String memberId, List<String> accountTypes, AccountCategoryEnum catEnum);

    /**
     * 查询会员账户关系,带缓存。（只能缓存memberId ,memberId+单个账户类型）
     * @param memberId
     * @param accountType
     * @param catEnum
     * @param cacheKeys 
     * @return
     */
    List<AccountDomain> getAccounts(String memberId, String accountType,
                                    AccountCategoryEnum catEnum, String cacheKeys);

    /**
     * 根据账户号查询会员账户关系
     * @param accountId
     * @return
     */
    AccountDomain getAccountByAccountId(String accountId,AccountCategoryEnum cat);
    
    /**
     * 根据会员号、外部标识号 查询会员账户关系
     * @return
     */
    AccountDomain getAccountByMemberIdAndAcctIdentity(String memberId, String acctIdentity);

    /**
     * 批量查询某种账户类型的账户集合
     * @param memberIds
     * @param accountType
     * @return
     */
    List<AccountDomain> getAccounts(List<String> memberIds, String accountType, AccountCategoryEnum cat);

    /**
     * 更新账户信息
     * @param account
     */
	void updateIdetStatus(AccountDomain account);
}
