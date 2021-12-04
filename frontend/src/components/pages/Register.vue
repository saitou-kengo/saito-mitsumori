<template>
<div class="container">
    <h1>見積登録</h1>
    <register-estimate-form
        :totalPrice="totalPrice"
        @init-estimate='estimate = $event'
    />
    <input-item-form
        @add-detail="addDetails"
    />
    <button @click="registerEstimate" class="btn btn-warning" id="button" :disabled="isInsert">見積登録</button>
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
            totalPrice: null,
            estimateId: null
        }
    },
    methods: {
    insertEstimate: function() {
        let form = new FormData();
        form.append('name', this.estimate.estimateName);
        form.append('amount', this.estimate.amount);
        form.append('budgetedAmount', this.totalPrice);
        form.append('customerCd', this.estimate.customer.cd);
        form.append('employeeCd', this.estimate.employee.cd);
        form.append('status', this.estimate.status);
        return new Promise(resolve => {
            this.$axios
            .post('http://localhost:8080/api/v1/estimates', form)
            .then(res => {
                this.estimateId = res.data;
                console.log(res.data + 'create new Estimate')
                resolve();
            })
            .catch(err => {
                alert('見積登録失敗');
                console.log("エラー：" + err);
            })
        })
    },
    insertDetail(subId, productCd, quantity) {
        let form = new FormData();
        form.append('estimateId', this.estimateId)
        form.append('subId', subId);
        form.append('productCd', productCd);
        form.append('quantity', quantity);
        this.$axios
        .post('http://localhost:8080/api/v1/estimate-details', form)
        .then(
            console.log('create new EstimateDetail')
        )
        .catch(err => {
            console.log('エラー：' + err);
        })
    },
    async registerEstimate() {
        await this.insertEstimate();
        this.details.forEach(detail => {
            this.insertDetail(detail.subId, detail.productCd, detail.quantity);
        })
        this.$router.go({path: this.$router.currentRoute.path, force: true})
    },
    addDetails: function(...inputs) {
        const [inputDetail, inputProduct, totalPrice] = inputs;
        const initDetail = {
            subId: this.details.length + 1,
            productCd: inputProduct.productCd,
            productName: inputProduct.productName,
            price: inputProduct.price,
            quantity: inputDetail.quantity,
            totalPrice: totalPrice
        }
        this.totalPrice += totalPrice;
        this.details.push(initDetail);
    },
    removeDetail: function(index, totalPrice) {
        console.log(index + '削除した');
        this.totalPrice -= totalPrice;
        this.details.splice(index - 1, 1);
    }
    },
    computed: {
        isInsert() {
            return this.estimate == null;
        }
    }
}
</script>