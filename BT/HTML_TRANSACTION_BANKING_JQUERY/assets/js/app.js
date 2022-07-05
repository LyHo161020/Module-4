class Customer {
    constructor(id, fullName, email, phone, address, balance, isDeleted) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.balance = balance;
        this.isDeleted = isDeleted;
    }
}


class Deposit {
    constructor(id, createAt, createBy, isDeleted, updateAt, updateBy, customerId, transactionAmount){
        this.id = id;
        this.createAt = createAt;
        this.createBy = createBy;
        this.isDeleted = isDeleted;
        this.updateAt = updateAt;
        this.updateBy = updateBy;
        this.customerId = customerId;
        this.transactionAmount = transactionAmount;
    }
}

class Withdraw {
    constructor(id, createAt, createBy, isDeleted, updateAt, updateBy, customerId, transactionAmount){
        this.id = id;
        this.createAt = createAt;
        this.createBy = createBy;
        this.isDeleted = isDeleted;
        this.updateAt = updateAt;
        this.updateBy = updateBy;
        this.customerId = customerId;
        this.transactionAmount = transactionAmount;
    }
}

class Transfer {
    constructor(id, createAt, createBy, isDeleted, updateAt, updateBy, fees, feesAmount, transactionAmount, transferAmount, repId, senderId){
        this.id = id;
        this.createAt = createAt;
        this.createBy = createBy;
        this.isDeleted = isDeleted;
        this.updateAt = updateAt;
        this.updateBy = updateBy;
        this.fees = fees;
        this.feesAmount = feesAmount;
        this.transactionAmount = transactionAmount;
        this.transferAmount = transferAmount;
    }
}