<template>
<div>
    <EstimateSearchForm/>
    <EstimateList/>
</div>
</template>

<script>
import EstimateSearchForm from '../modules/EstimateSearchForm.vue'
import EstimateList from '../modules/EstimateList.vue'
import CustomerSearchDialog from '../modules/CustomerSearchDialog.vue'
import EmployeeSearchDialog from '../modules/EmployeeSearchDialog.vue'



export default {
    components: {
    EstimateSearchForm,
    EstimateList,
    CustomerSearchDialog,
    EmployeeSearchDialog
    }
}
</script>

<style>

</style>