<template>
<div class="container">
    {{ estimate }}
    <h1>見積登録</h1>
    <register-estimate-form
        :totalPrice="totalPrice"
        @init-estimate='estimate = $event'
    />
    <input-item-form
        @add-detail="addDetails"
    />
    <button @click="registerEstimate" class="btn btn-warning">見積登録</button>
    <edit-estimate-details-list :details="details"
        @delete-detail="removeDetail"
    />
</div>
</template>

<script>
import RegisterEstimateForm from '../modules/Form/RegisterEstimateForm.vue'
import InputItemForm from '../modules/Form/InputItemForm.vue'
import EditEstimateDetailsList from '../modules/ListView/EditEstimateDetailsList.vue'

export default {
    components: {
    RegisterEstimateForm,
    InputItemForm,
    EditEstimateDetailsList
    },
    data() {
        return {
            estimate: null,
            details: [],
            totalPrice: null
        }
    },
    methods: {
    insertEstimate: function() {
        let params = new URLSearchParams();
        params.append('name', this.estimate.estimateName);
        params.append('amount', this.estimate.amount);
        params.append('budgetedAmount', this.estimate.budgetedAmount);
        params.append('customerCd', this.estimate.customer.cd);
        params.append('employeeCd', this.estimate.employee.cd);
        params.append('status', this.estimate.status);
        this.$axios
        .post('http://localhost:8080/api/v1/estimates', params)
        .then(res => {
            console.log(res.data + 'create new Estimate')
        }
        )
        .catch((err) => {
            alert('見積登録失敗')
            console.log("エラー：" + err);
        })
    },
    insertDetail() {
        const convertDetails = Object.assign({}, this.estimate);
        this.$axios
        .post('http://localhost:8080/api/v1/estimate-details', {
            params: {
                details: convertDetails
            }
            })
        .then(
            console.log('create new EstimateDetail')
        )
        .catch(err => {
            console.log('エラー：' + err);
        })
    },
    registerEstimate: function() {
        this.insertEstimate();
        // this.insertDetail();
        // this.$router.go({path: this.$router.currentRoute.path, force: true})
    },
    addDetails: function(...inputs) {
        const [inputDetail, inputProduct, totalPrice] = inputs;
        const initDetail = {
            id: this.details.length + 1,
            productCd: inputProduct.productCd,
            productName: inputProduct.productName,
            price: inputProduct.price,
            quantity: inputDetail.quantity,
            totalPrice: totalPrice
        }
        this.totalPrice += totalPrice;
        this.details.push(initDetail);
    },
    removeDetail: function(index) {
        console.log(index + '削除した');
        this.details.splice(index - 1, 1);
    }
    }
}
</script>

<style>

</style>