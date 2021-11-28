<template>
<div>
    <h2>見積検索</h2>
    <p>検索条件に部分一致した見積情報が結果に表示されます。</p>
    <span id="index">検索条件</span>
    <br>
    <span>
        <label for="estimate_id">見積番号</label>
        <input v-model="estimateId" type="text" id="estimate_id"/>
        <button v-on:click:key="getAllDetailListById">検索</button>
    </span>
    <br>
    <span>
        <label for="estimate_name">案件名</label>
        <input v-model="estimateName" type="text" id="estimate_name"/>
        <button v-on:click:key="getAllDetailListByLikeName">検索</button>
    </span>
    <br>
    <span>
        <label for="status">見積ステータス</label>
        <select v-model="status" id="status">
            <option value="1">見積中</option>
            <option value="2">見積完了</option>
            <option value="3">受注済み</option>
        </select>
        <button v-on:click:key="getAllDetailListByLikeStatus">検索</button>
    </span>
    <br>
    <span>
        <label for="customer_name">顧客名</label>
        <input v-model="customerName" type="text" id="customer_name"/>
        <input type="button" value="顧客選択" id="customer_select"/>
        <input type="button" value="クリア" id="clear"/>
        <button v-on:click:key="getAllDetailListByLikeCustomerName">検索</button>
    </span>
    <br>
    <span>
        <label for="employee_name">担当者名</label>
        <input v-model="employeeName" type="text" id="employee_name"/>
        <input type="button" value="担当者選択" id="manager_select"/>
        <input type="button" value="クリア" id="clear"/>
        <button v-on:click:key="getAllDetailListByLikeEmployeeName">検索</button>
    </span>
    <br>
</div>
</template>

<script>
import axios from 'axios'

export default {
    data() {
        return {
            details: [],
            estimateId: "",
            estimateName: "",
            status: "",
            customerName: "",
            employeeName: "",
            budgetedAmount: "",
            estimateAmount: "",
            totalPrice: ""
        }
    },
    methods: {
        getAllDetailListById: function() {
            axios
            .get("/api/v1/estimates/:id")
            .then((res) => {
                console.log(res);
                this.details = res.data})
            .catch((err) => {
                console.log("エラー：" + err);
            });
        },
        getAllDetailListByLikeName: function() {
            axios
            .get("/api/v1/estimates/like-name/:name")
            .then((res) => {
                console.log(res);
                this.details = res.data})
            .catch((err) => {
                console.log("エラー：" + err);
            });
        },
        getAllDetailListByLikeStatus: function() {
            axios
            .get("/api/v1/estimates/like-status/:status")
            .then((res) => {
                console.log(res);
                this.details = res.data})
            .catch((err) => {
                console.log("エラー：" + err);
            });
        },
        getAllDetailListByLikeCustomerName: function() {
            axios
            .get("/api/v1/estimates/customer-cd/:cd")
            .then((res) => {
                console.log(res);
                this.details = res.data})
            .catch((err) => {
                console.log("エラー：" + err);
            });
        },
        getAllDetailListByLikeEmployeeName: function() {
            axios
            .get("/api/v1/estimates/employee-cd/:cd")
            .then((res) => {
                console.log(res);
                this.details = res.data})
            .catch((err) => {
                console.log("エラー：" + err);
            });
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