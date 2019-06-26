package com.acme.banking.dbo.domain;

import java.util.ArrayList;

public interface BranchInterface {
    public ArrayList<Account> getAccounts();

    public ArrayList<BranchInterface> getChildrens();


}
