<template>
<div>
    <h2>見積検索</h2>
    <p>検索条件に部分一致した見積情報が結果に表示されます。</p>
    <span id="index">検索条件</span>
    <br>
    <span>
        <label for="estimate_id">見積番号</label>
        <input v-model="estimateId" type="text" id="estimate_id"/>
        <button @click="searchByLikeId">検索</button>
    </span>
    <br>
    <span>
        <label for="estimate_name">案件名</label>
        <input v-model="estimateName" type="text" id="estimate_name"/>
        <button @click="searchByLikeName">検索</button>
    </span>
    <br>
    <span>
        <label for="status">見積ステータス</label>
        <select v-model="status" id="status">
            <option value="1">見積中</option>
            <option value="2">見積完了</option>
            <option value="3">受注済み</option>
        </select>
        <button @click="searchByLikeStatus">検索</button>
    </span>
    <br>
    <span>
        <label for="customer_name">顧客名</label>
        <input v-model="customerName" type="text" id="customer_name" disabled="disabled"/>
        <button @click="showCustomerSearchDialog">顧客選択</button>
        <customer-search-dialog ref="cDialog"
            @select-customer='customerName = $event'
        />
        <button @click="clearCustomer">クリア</button>
        <button @click="searchByLikeCustomer">検索</button>
    </span>
    <br>
    <span>
        <label for="employee_name">担当者名</label>
        <input v-model="employeeName" type="text" id="employee_name" disabled="disabled"/>
        <button @click="showEmployeeSearchDialog">担当者選択</button>
        <employee-search-dialog ref="eDialog"
            @select-employee='employeeName = $event'
        />
        <button @click="clearEmployee">クリア</button>
        <button @click="searchByLikeEmployee">検索</button>
    </span>
    <br>
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
            estimateId: "入力してください",
            estimateName: "入力してください",
            status: "選択してください",
            customerName: "入力してください",
            employeeName: "入力してください"
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