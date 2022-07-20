class Customer {
    constructor(id, fullName, email, phone, location, balance, isDeleted) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.phone = phone;
        this.location = location;
        this.balance = balance;
        this.isDeleted = isDeleted;
    }
}

class LocationRegion {
    constructor(id, provinceId, provinceName, districtID, districtName, wardId, wardName, address){
        this.id = id;
        this.provinceId = provinceId;
        this.provinceName = provinceName;
        this.districtID = districtID;
        this.districtName = districtName;
        this.wardId = wardId;
        this.wardName = wardName;
        this.address = address;
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
        this.repId = repId;
        this.senderId = senderId;
    }
}