<template>
<modal name="customerDialog" :draggable="true" :adaptive="true" :scrollable="true" width="75%" height="auto">
    <div class="container">
    <div class="form-group form-inline" id="modal-header">
        顧客検索
        <br>
        名前を入力してください
    </div>
    <div class="input-group mb-3" id="modal-search-form">
        <div class="input-group-prepend">
            <span class="input-group-text">会社・個人名（部分一致）</span>
        </div>
        <input v-model="customerName" type="text" id="customer_name" placeholder="入力してください"/>
        <button @click="getCustomersListByLikeName" class="btn btn-primary" id="button">検索</button>
    </div>
    <div id="modal-body">
    <table class="table table-bordered">
        <thead class="thead-lignt">
            <tr>
                <th id="dialog-customer-cd">顧客コード</th>
                <th id="dialog-customer-name">顧客名</th>
                <th id="dialog-select">選択</th>
            </tr>
        </thead>
        <tbody>
            <tr v-for="customer in customers" :key="customer.cd">
                <td id="dialog-customer-cd">{{ customer.cd }}</td>
                <td id="dialog-customer-name">{{ customer.name }}</td>
                <td id="dialog-select"><div @click="closeDialog(customer.cd, customer.name)" id="text-link">選択</div></td>
            </tr>
        </tbody>
    </table>
    </div>
    </div>
    </modal>
</template>

<script>

export default {
    data() {
        return {
            customers: null,
            customerName: null
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
            this.$modal.show('customerDialog');
        },
        closeDialog: function(customerCd, customerName) {
            this.$emit('select-customer', customerCd, customerName);
            this.$modal.hide('customerDialog');
        }
    },
    created: function() {
        this.getCustomersList();
    }
}
</script>
