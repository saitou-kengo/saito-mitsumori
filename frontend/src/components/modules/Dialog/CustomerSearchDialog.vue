<template>
<div>
    <div id="overlay" v-show="showFlag">
    <div id="dialog">
    <div id="title">
        顧客検索
    </div>
    <br>
    <p>名前を入力してください。</p>
    <span>
        <label for="customer_name">会社・個人名（部分一致）</label>
        <input v-model="customerName" type="text" id="customer_name"/>
        <button @click="getCustomersListByLikeName">検索</button>
    </span>
    <br>
    <table>
        <tr>
            <th>顧客コード</th>
            <th>顧客名</th>
            <th>選択</th>
        </tr>
        <div v-for="customer in customers" :key="customer.cd">
        <tr>
            <td>{{ customer.cd }}</td>
            <td>{{ customer.name }}</td>
            <td><span @click="closeDialog(customer.name)">選択</span></td>
        </tr>
        </div>
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
            customerName: "入力してください",
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
        closeDialog: function(customerName) {
            this.$emit('select-customer', customerName);
            this.showFlag = false;
        }
    },
    created: function() {
        this.getCustomersList();
    }
}
</script>

<style>
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
    padding: 1em;
    background: #fff;

}
</style>
