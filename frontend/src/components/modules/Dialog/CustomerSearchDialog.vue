<template>
<modal name="customer-dialog" :draggable="true" :adaptive="true" :scrollable="true" width="75%" height="auto">
    <div class="container">
        <div class="row margin-15" id="modal-header">
            <div class="col">
                <span class="page-title">
                    顧客検索
                </span>
                <br>
                名前を入力してください
            </div>
        </div>
        <div class="row margin-15">
            <div class="col">
                <div class="input-group mb-1" id="modal-search-form">
                    <div class="input-group-prepend">
                        <span class="input-group-text">
                            会社・個人名（部分一致）
                        </span>
                    </div>
                    <input v-model="customerName" type="text" class="col-md-3" id="customer_name" placeholder="入力してください"/>
                    <button @click="getCustomersListByLikeName" class="btn btn-primary" id="button">検索</button>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col">
                <span id="index">
                    検索結果
                </span>
            </div>
        </div>
        <div class="row" id="modal-body">
            <div class="col">
                <table class="table table-bordered">
                    <thead class="thead-lignt">
                        <tr>
                            <th id="dialog-customer-cd">
                                <svg xmlns="http://www.w3.org/2000/svg" width="12" height="12" fill="currentColor" class="bi bi-calendar-plus-fill" viewBox="0 0 16 16" color="black">
                                <path d="M4 .5a.5.5 0 0 0-1 0V1H2a2 2 0 0 0-2 2v1h16V3a2 2 0 0 0-2-2h-1V.5a.5.5 0 0 0-1 0V1H4V.5zM16 14V5H0v9a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2zM8.5 8.5V10H10a.5.5 0 0 1 0 1H8.5v1.5a.5.5 0 0 1-1 0V11H6a.5.5 0 0 1 0-1h1.5V8.5a.5.5 0 0 1 1 0z"/>
                                </svg>
                                顧客コード
                            </th>
                            <th id="dialog-customer-name">
                                <svg xmlns="http://www.w3.org/2000/svg" width="12" height="12" fill="currentColor" class="bi bi-info-circle-fill" viewBox="0 0 16 16" color="black">
                                <path d="M8 16A8 8 0 1 0 8 0a8 8 0 0 0 0 16zm.93-9.412l-1 4.705c-.07.34.029.533.304.533.194 0 .487-.07.686-.246l-.088.416c-.287.346-.92.598-1.465.598-.703 0-1.002-.422-.808-1.319l.738-3.468c.064-.293.006-.399-.287-.47l-.451-.081.082-.381 2.29-.287zM8 5.5a1 1 0 1 1 0-2 1 1 0 0 1 0 2z"/>
                                </svg>
                                顧客名
                                </th>
                            <th id="dialog-select">
                                <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-pencil-square" viewBox="0 0 16 16">
                                <path d="M15.502 1.94a.5.5 0 0 1 0 .706L14.459 3.69l-2-2L13.502.646a.5.5 0 0 1 .707 0l1.293 1.293zm-1.75 2.456l-2-2L4.939 9.21a.5.5 0 0 0-.121.196l-.805 2.414a.25.25 0 0 0 .316.316l2.414-.805a.5.5 0 0 0 .196-.12l6.813-6.814z"/>
                                <path fill-rule="evenodd" d="M1 13.5A1.5 1.5 0 0 0 2.5 15h11a1.5 1.5 0 0 0 1.5-1.5v-6a.5.5 0 0 0-1 0v6a.5.5 0 0 1-.5.5h-11a.5.5 0 0 1-.5-.5v-11a.5.5 0 0 1 .5-.5H9a.5.5 0 0 0 0-1H2.5A1.5 1.5 0 0 0 1 2.5v11z"/>
                                </svg>
                            </th>
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
                console.log('Error' + err);
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
                console.log('Error' + err);
            })
        },
        showDialog: function() {
            this.$modal.show('customer-dialog');
        },
        closeDialog: function(customerCd, customerName) {
            this.$emit('select-customer', customerCd, customerName);
            this.$modal.hide('customer-dialog');
        }
    },
    created: function() {
        this.getCustomersList();
    }
}
</script>
