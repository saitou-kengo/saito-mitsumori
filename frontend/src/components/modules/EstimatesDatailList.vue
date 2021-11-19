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
            <td>1</td>
            <td>テストアイテム</td>
            <td>5000</td>
            <td>2</td>
            <td>10000</td>
        </tr>
    </table>
</div>
</template>

<script>
export default {

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