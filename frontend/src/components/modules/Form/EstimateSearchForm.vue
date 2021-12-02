<template>
<div class="container">
    <h2>見積検索</h2>
    <p>検索条件に部分一致した見積情報が結果に表示されます。</p>
    <span id="index">検索条件</span>
    <br>
    <div class="input-group mb-3">
        <div class="input-group-prepend">
            <span class="input-group-text">見積番号</span>
        </div>
        <input v-model="estimateId" type="text" id="estimate_id" placeholder="入力してください"/>
        <button @click="searchByLikeId" class="btn btn-primary">検索</button>
    </div>
    <div class="input-group mb-3">
        <div class="input-group-prepend">
            <span class="input-group-text">案件名</span>
        </div>
        <input v-model="estimateName" type="text" id="estimate_name" placeholder="入力してください"/>
        <button @click="searchByLikeName" class="btn btn-primary">検索</button>
    </div>
    <div class="input-group mb-3">
        <div class="input-group-prepend">
            <span class="input-group-text">見積ステータス</span>
        </div>
        <select v-model="status" id="status" placeholder="選択してください">
            <option value="1">見積中</option>
            <option value="2">見積完了</option>
            <option value="3">受注済み</option>
        </select>
        <button @click="searchByLikeStatus" class="btn btn-primary">検索</button>
    </div>
    <div class="input-group mb-3">
        <div class="input-group-prepend">
            <span class="input-group-text">顧客名</span>
        </div>
        <input v-model="customerName" type="text" id="customer_name" disabled="disabled" placeholder="選択してください"/>
        <button @click="showCustomerSearchDialog" class="btn btn-success">顧客選択</button>
        <customer-search-dialog ref="cDialog"
            @select-customer='selectCustomer'
        />
        <button @click="clearCustomer" class="btn btn-secondary">クリア</button>
        <button @click="searchByLikeCustomer" class="btn btn-primary">検索</button>
    </div>
    <div class="input-group mb-3">
        <div class="input-group-prepend">
            <span class="input-group-text">担当者名</span>
        </div>
        <input v-model="employeeName" type="text" id="employee_name" disabled="disabled" placeholder="選択してください"/>
        <button @click="showEmployeeSearchDialog" class="btn btn-success">担当者選択</button>
        <employee-search-dialog ref="eDialog"
            @select-employee='selectEmployee'
        />
        <button @click="clearEmployee" class="btn btn-secondary">クリア</button>
        <button @click="searchByLikeEmployee" class="btn btn-primary">検索</button>
    </div>
</div>
</template>

<script>
import CustomerSearchDialog from '../Dialog/CustomerSearchDialog.vue'
import EmployeeSearchDialog from '../Dialog/EmployeeSearchDialog.vue'

export default {
    components: {
        CustomerSearchDialog,
        EmployeeSearchDialog
    },
    data() {
        return {
            estimateId: null,
            estimateName: null,
            status: null,
            customerCd: null,
            customerName: null,
            employeeCd: null,
            employeeName: null
        }
    },
    methods: {
        searchById: function() {
            this.$emit('search-by-id', this.estimateId);
        },
        searchByLikeId: function() {
            this.$emit('search-by-like-id', this.estimateId);
        },
        searchByLikeName: function() {
            this.$emit('search-by-like-name', this.estimateName);
        },
        searchByLikeStatus: function() {
            this.$emit('search-by-like-status', this.status);
        },
        searchByLikeCustomer: function() {
            this.$emit('search-by-like-customer', this.customerName);
        },
        searchByLikeEmployee: function() {
            this.$emit('search-by-like-employee', this.employeeName);
        },
        showCustomerDialog: function() {
            this.$emit('show-customer-dialog');
        },
        showEmployeeDialog: function() {
            this.$emit('show-employee-dialog');
        },
        clearCustomer: function() {
            this.customerName = null;
        },
        clearEmployee: function() {
            this.employeeName = null;
        },
        showCustomerSearchDialog: function() {
            this.$refs.cDialog.showDialog();
        },
        showEmployeeSearchDialog: function() {
            this.$refs.eDialog.showDialog();
        },
        selectCustomer: function(customerCd, customerName) {
            this.customerCd = customerCd;
            this.customerName = customerName;
        },
        selectEmployee: function(employeeCd, employeeName) {
            this.employeeCd = employeeCd;
            this.employeeName = employeeName;            
        }
    }
}
</script>

<style>
#index {
    display: flex;
    align-items: center;
    justify-content: center;
}

#index:before, .catch:after {
    border-top: 1px solid;
    content: "";
    width: 3em;
}

#index:before {
    margin-right: 1em;
}

#index:after {
    margin-left: 1em;
}

label {
    background-color:rgb(219, 219, 219);
}



</style>