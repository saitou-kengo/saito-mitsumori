<template>
<div>
    <span id="index">見積明細</span>
    <br>
    <table>
        <tr>
            <th>枝番</th>
            <th>商品名</th>
            <th>単価</th>
            <th>数量</th>
            <th>金額</th>
            <th>削除</th>
        </tr>
        <div v-for="detail in details" :key="detail.id">
        <tr>
            <td>{{ detail.id }}</td>
            <td>{{ detail.productName }}</td>
            <td>{{ detail.price }}</td>
            <td>{{ detail.quantity }}</td>
            <td>{{ detail.totalPrice }}</td>
            <td><span @click="deleteDetail(detail.id)">削除</span></td>
        </tr>
        </div>
    </table>
</div>
</template>

<script>

export default {
    props: ['details'],
    methods: {
        deleteDetail: function(id) {
            this.$emit('delete-detail', id);
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
</style>