<template>
<div>
    <estimate-search-form/>
    <estimate-list/>
</div>
</template>

<script>
import EstimateSearchForm from '../modules/EstimateSearchForm.vue'
import EstimateList from '../modules/EstimateList.vue'

export default {
    components: {
    EstimateSearchForm,
    EstimateList
    }
}
</script>

<style>

</style>