<template>
<div class="container">
    <estimate-search-form 
        @search-by-like-id="searchByLikeId"
        @search-by-like-name="searchByLikeName"
        @search-by-like-status="searchByLikeStatus"
        @search-by-like-customer="searchByLikeCustomer"
        @search-by-like-employee="searchByLikeEmployee"
        />
    <estimate-list :estimates="estimates"/>
</div>
</template>

<script>
import EstimateSearchForm from '../modules/Form/EstimateSearchForm.vue'
import EstimateList from '../modules/ListView/EstimateList.vue'

export default {
    components: {
        EstimateSearchForm,
        EstimateList
    },
    data() {
        return {
            estimates: null,
            id: null
        };
    },
    methods: {
        getEstimatesList: function() {
            this.$axios
            .get('http://localhost:8080/api/v1/estimates')
            .then(res => {
                this.estimates = res.data;
                console.log('retrieve all Estimate');
            })
            .catch(err => {
                console.log('Error：' + err);
            });
        },
        searchById: function(id) {
            this.$axios
            .get('http://localhost:8080/api/v1/estimates/:id', {
                params: {
                    id: id
                }
            })
            .then(res => {
                this.estimates = res.data;
                console.log('retrieve a Estimate by :id');
            })
            .catch(err => {
                console.log('Error：' + err);
            })
        },
        searchByLikeId: function(id) {
            this.$axios
            .get('http://localhost:8080/api/v1/estimates/like-id/:id', {
                params: {
                    id: id
                }
            })
            .then(res => {
                this.estimates = res.data;
                console.log('retrieve a Estimate by like :id')
            })
            .catch(err => {
                console.log('Error：' + err);
            })
        },
        searchByLikeName: function(estimateName) {
            this.$axios
            .get('http://localhost:8080/api/v1/estimates/like-name/:name', {
                params: {
                    name: estimateName
                }
            })
            .then(res => {
                this.estimates = res.data;
                console.log('retrieve a Estimate by like :name')
            })
            .catch(err => {
                console.log('Error：' + err);
            })
        },
        searchByLikeStatus: function(status) {
            this.$axios
            .get('http://localhost:8080/api/v1/estimates/like-status/:status', {
                params: {
                    status: status
                }
            })
            .then(res => {
                this.estimates = res.data;
                console.log('retrieve a Estimate by like :status')
            })
            .catch(err => {
                console.log('Error：' + err);
            })
        },
        searchByLikeCustomer: function(customerCd) {
            this.$axios
            .get('http://localhost:8080/api/v1/estimates/customer-cd/:cd', {
                params: {
                    customerCd: customerCd
                }
            })
            .then(res => {
                this.estimates = res.data;
                console.log('retrieve a Estimate by like :customer_cd')
            })
            .catch(err => {
                console.log('Error：' + err);
            })
        },
        searchByLikeEmployee: function(employeeCd) {
            this.$axios
            .get('http://localhost:8080/api/v1/estimates/employee-cd/:cd', {
                params: {
                    employeeCd: employeeCd
                }
            })
            .then(res => {
                this.estimates = res.data;
                console.log('retrieve a Estimate by like :employee_cd')
            })
            .catch(err => {
                console.log('Error：' + err);
            })
        }
    },
    mounted: function() {
        this.getEstimatesList();
    }
}
</script>