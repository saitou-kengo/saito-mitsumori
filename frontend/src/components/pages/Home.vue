<template>
<div>
    <h2>見積検索</h2>
    <p>検索条件に部分一致した見積情報が結果に表示されます。</p>
    <SearchForm/>
    <SearchResultList/>
</div>
</template>

<script>
import SearchForm from '../modules/SearchForm.vue'
import SearchResultList from '../modules/SearchResultList.vue'


export default {
    components: {
    SearchForm,
    SearchResultList
    }
}
</script>

<style>

</style>