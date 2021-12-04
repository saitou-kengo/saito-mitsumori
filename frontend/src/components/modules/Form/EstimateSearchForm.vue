<template>
    <div class="container">
    <h2>見積検索</h2>
    <p>検索条件に部分一致した見積情報が結果に表示されます。</p>
    <span id="index">検索条件</span>
    <br>
    <div class="form-group row">
        <div class="input-group mb-1">
            <div class="input-group-prepend">
                <span class="input-group-text col-md-2">見積番号</span>
            </div>
            <input v-model="estimateId" class="col-md-4" type="text" id="estimate_id" placeholder="入力してください"/>
            <button @click="searchByLikeId" class="btn btn-primary col-md-1" id="button" :disabled="isEstimateIdSearch">検索</button>
        </div>
    </div>
    <div class="form-group row">
        <div class="input-group mb-1">
            <div class="input-group-prepend">
                <span class="input-group-text col-md-2">案件名</span>
            </div>
            <input v-model="estimateName" class="col-md-8" type="text" id="estimate_name" placeholder="入力してください"/>
            <button @click="searchByLikeName" class="btn btn-primary col-md-1" id="button" :disabled="isEstimateNameSearch">検索</button>
        </div>
    </div>
    <div class="form-group row">
        <div class="input-group mb-1">
            <div class="input-group-prepend">
                <span class="input-group-text col-md-2">見積ステータス</span>
            </div>
            <select v-model="status" class="col-md-4" id="status" placeholder="選択してください">
                <option value="1">見積中</option>
                <option value="2">見積完了</option>
                <option value="3">受注済み</option>
            </select>
            <button @click="searchByLikeStatus" class="btn btn-primary col-md-1" id="button" :disabled="isStatusSearch">検索</button>
        </div>
    </div>
    <div class="form-group row">
        <div class="input-group mb-1">
            <div class="input-group-prepend">
                <span class="input-group-text col-md-2">顧客名</span>
            </div>
            <input v-model="customerName" class="col-md-5" type="text" id="customer_name" disabled="disabled" placeholder="選択してください"/>
            <button @click="showCustomerSearchDialog" class="btn btn-success col-md-1" id="button">顧客選択</button>
            <customer-search-dialog ref="cDialog"
                @select-customer='selectCustomer'
            />
            <button @click="clearCustomer" class="btn btn-secondary col-md-1" id="button">クリア</button>
            <button @click="searchByLikeCustomer" class="btn btn-primary col-md-1" id="button" :disabled="isCustomerSearch">検索</button>
        </div>
    </div>
    <div class="form-group row">
        <div class="input-group mb-1">
            <div class="input-group-prepend">
                <span class="input-group-text col-md-2">担当者名</span>
            </div>
            <input v-model="employeeName" class="col-md-5" type="text" id="employee_name" disabled="disabled" placeholder="選択してください"/>
            <button @click="showEmployeeSearchDialog" class="btn btn-success col-md-1" id="button">担当者選択</button>
            <employee-search-dialog ref="eDialog"
                @select-employee='selectEmployee'
            />
            <button @click="clearEmployee" class="btn btn-secondary col-md-1" id="button">クリア</button>
            <button @click="searchByLikeEmployee" class="btn btn-primary col-md-1" id="button" :disabled="isEmployeeSearch">検索</button>
        </div>
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
            this.$emit('search-by-like-customer', this.customerCd);
        },
        searchByLikeEmployee: function() {
            this.$emit('search-by-like-employee', this.employeeCd);
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
    },
    computed: {
        isEstimateIdSearch() {
            return this.estimateId == null;
        },
        isEstimateNameSearch() {
            return this.estimateName == null;
        },
        isStatusSearch() {
            return this.status == null;
        },
        isCustomerSearch() {
            return this.customerCd == null;
        },
        isEmployeeSearch() {
            return this.employeeCd == null;
        }
    }
}
</script>