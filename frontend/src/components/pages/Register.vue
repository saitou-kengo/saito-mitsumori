<template>
<div>
    <h1>見積登録</h1>
    <register-estimate-form/>
    <input-item-form/>
    <button @click="registerEstimate">見積登録</button>
    <estimates-datail-list :details="details"/>
</div>
</template>

<script>
import RegisterEstimateForm from '../modules/Form/RegisterEstimateForm.vue'
import InputItemForm from '../modules/Form/InputItemForm.vue'
import EstimatesDatailList from '../modules/ListView/EstimatesDatailList.vue'

export default {
    components: {
    RegisterEstimateForm,
    InputItemForm,
    EstimatesDatailList
    },
    data() {
        return {
            estimate: {
                estimateName: null,
                status: null,
                customerName: null,
                employeeName: null,
                budgetedAmount: null,
                amount: null,
            },
            details: [],
            detail: {
                subId: null,
                productCd: null,
                productName: null,
                price: null,
                quantity: null,
                totalPrice: null,
                estimateId: null
            }
        }
    },
    methods: {
    insertEstimate: function() {
        this.$axios
        .post("http://localhost:8080/api/v1/estimates/", {
            params: {
                name: this.estimate.estimateName,
                amount: this.estimate.amount,
                budgetedAmount: this.estimate.budgetedAmount,
                customerName: this.estimate.customerName,
                employeeName: this.estimate.employeeName,
                status: this.estimate.status
            }
        })
            .then((res) => {
                console.log(res + 'create new Estimate');
            })
            .catch((err) => {
                console.log("エラー：" + err);
            })
        },
    getEstimateDetailsListById() {
        this.$axios
        .get('http://localhost:8080/api/v1/estimate-details/:id', {
            params: {
            id: this.id
            }
        })
    .then(res => {
        this.details = res.data;
        console.log(res.data);
        })
    .catch(err => {
        console.log('エラー：' + err);
        });
    },
    insertDetail() {
        this.$axios
        .post('http://localhost:8080/api/v1/estimate-details', {
            params: {
                details: this.details
            }
            })
        .then(res => {
            console.log(res.data + 'create new EstimateDetail');
        })
        .catch(err => {
            console.log('エラー：' + err);
        })
    },
    registerEstimate: function() {
        this.insertEstimate();
        this.insertDetail();
    },
    addDetails: function(...inputs) {
        const [inputDetail, inputProduct] = inputs;
        this.detail.subId = this.details.length + 1;
        this.detail.productCd = inputProduct.productCd;
        this.detail.productName = inputProduct.productName;
        this.detail.price = inputProduct.price;
        this.detail.quantity = inputDetail.quantity;
        this.detail.totalPrice = inputDetail.totalPrice;
        this.details.push(this.detail);
    },
    removeDetail: function(index) {
        this.details.splice(index,index);
    }
    }
}
</script>

<style>

</style>