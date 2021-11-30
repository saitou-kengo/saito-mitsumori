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
        </tr>
        <tr>
        <div v-if="details === null">
            データ無し
        </div>
        <div v-else>
        <div v-for="detail in details" :key="detail.id">

            <td>{{ detail.subId }}</td>
            <td>{{ detail.productName }}</td>
            <td>{{ detail.price }}</td>
            <td>{{ detail.quantity }}</td>
            <td>{{ detail.totalPrice }}</td>

        </div>
        </div>
        </tr>
        </table>
</div>
</template>

<script>

export default {
    props: ['details']
}
</script>

<style>
th,td {
    border: solid 1px;
}

table {
    border-collapse:  collapse;
}

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