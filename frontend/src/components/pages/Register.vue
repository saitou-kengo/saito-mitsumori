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
    <edit-estimate-details-list :details="details"/>
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
        this.$axios
        .post("http://localhost:8080/api/v1/estimates", {
            params: {
                estimate: this.estimate.estimateName
            }
        })
            .then((res) => {
                alert('見積登録成功')
                console.log(res + 'create new Estimate');
            })
            .catch((err) => {
                alert('見積登録失敗')
                console.log("エラー：" + err);
            })
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
        console.log('インサート:', this.estimate);
        this.insertEstimate();
        this.insertDetail();
        this.$router.go({path: this.$router.currentRoute.path, force: true})
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
        this.details.splice(index,index);
    }
    }
}
</script>

<style>

</style>