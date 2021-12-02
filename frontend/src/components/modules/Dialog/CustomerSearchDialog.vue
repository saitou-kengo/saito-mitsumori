<template>
<div class="container">
    <div id="overlay" v-show="showFlag">
    <div id="dialog">
    <div class="form-group form-inline" id="title">
        顧客検索
    </div>
    <p>名前を入力してください。</p>
    <div class="input-group mb-3">
        <div class="input-group-prepend">
            <span class="input-group-text">会社・個人名（部分一致）</span>
        </div>
        <input v-model="customerName" type="text" id="customer_name" placeholder="入力してください"/>
        <button @click="getCustomersListByLikeName" class="btn btn-primary">検索</button>
    </div>
    <table class="table table-bordered">
        <thead class="thead-lignt">
            <tr>
                <th id="cstomerCd">顧客コード</th>
                <th id="customerName">顧客名</th>
                <th id="select">選択</th>
            </tr>
        </thead>
        <tbody>
        <div v-for="customer in customers" :key="customer.cd">
            <tr>
                <td id="cstomerCd">{{ customer.cd }}</td>
                <td id="customerName">{{ customer.name }}</td>
                <td id="select"><div @click="closeDialog(customer.cd, customer.name)">選択</div></td>
            </tr>
        </div>
        </tbody>
    </table>
    </div>
    </div>
</div>
</template>

<script>

export default {
    data() {
        return {
            customers: null,
            customerName: null,
            showFlag: false
        }
    },
    methods: {
        getCustomersList: function() {
            this.$axios
            .get('http://localhost:8080/api/v1/customers')
            .then(res => {
                this.customers = res.data;
                console.log('retrieve all Customer');
            })
            .catch(err => {
                console.log('エラー：' + err);
            })
        },
        getCustomersListByLikeName: function() {
            this.$axios
            .get('http://localhost:8080/api/v1/customers/name/:name', {
                params: {
                    name: this.customerName
                }
            })
            .then(res => {
                this.customers = res.data;
                console.log('retrieve a Customer by :name');
            })
            .catch(err => {
                console.log('エラー：' + err);
            })
        },
        showDialog: function() {
            this.showFlag = true;
        },
        closeDialog: function(customerCd, customerName) {
            this.$emit('select-customer', customerCd, customerName);
            this.showFlag = false;
        }
    },
    created: function() {
        this.getCustomersList();
    }
}
</script>

<style>
table {
    margin: auto;
}

tbody {
    overflow: scroll;
}

#cstomerCd {
    width: 25%;
}

#cstomerName {
    width: 50%;
}

#select {
    width: 25%;
}

#overlay{
    z-index: 1;
    position: fixed;
    top: 0;
    left: 0;
    width: 100%;
    height: 100%;
    background-color: rgba(0,0,0,0.5);
    display: flex;
    align-items: center;
    justify-content: center;
}

#dialog{
    z-index: 2;
    width: 50%;
    height: 50%;
    padding: 1em;
    background: #fff;

}
</style>
