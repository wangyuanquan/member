package com.rechenggit.core.domainservice.repository.impl;

import com.netfinworks.common.lang.StringUtil;
import com.rechenggit.core.common.BaseResponse;
import com.rechenggit.core.domain.AccountDomain;
import com.rechenggit.core.domain.account.OpenAccountInfo;
import com.rechenggit.core.domain.enums.AccountCategoryEnum;
import com.rechenggit.core.domainservice.repository.AccountRepository;
import com.rechenggit.core.exception.MaBizException;

import java.util.List;

public class AccountRepositoryImpl implements AccountRepository {
    @Override
    public void store(AccountDomain account) {

    }

    @Override
    public void storeForUpdate(AccountDomain account) throws MaBizException {

    }

    @Override
    public void reStore(AccountDomain account, List<String> cacheKeys) throws MaBizException {

    }

    @Override
    public void reStoreBaseAccount(AccountDomain account) throws MaBizException {

    }

    @Override
    public List<AccountDomain> getAccounts(String memberId, List<Long> accountTypes) {
        return null;
    }

    @Override
    public List<AccountDomain> getAccounts(String memberId, List<String> accountTypes, AccountCategoryEnum catEnum) {
        return null;
    }

    @Override
    public List<AccountDomain> getAccounts(String memberId, String accountType, AccountCategoryEnum catEnum, String cacheKeys) {
        return null;
    }

    @Override
    public AccountDomain getAccountByAccountId(String accountId, AccountCategoryEnum cat) {
        return null;
    }

    @Override
    public AccountDomain getAccountByMemberIdAndAcctIdentity(String memberId, String acctIdentity) {
        return null;
    }

    @Override
    public List<AccountDomain> getAccounts(List<String> memberIds, String accountType, AccountCategoryEnum cat) {
        return null;
    }

    @Override
    public void updateIdetStatus(AccountDomain account) {

    }

    @Override
    public String openAccount(OpenAccountInfo openAccountInfo) throws MaBizException {

        return null;
    }
}
