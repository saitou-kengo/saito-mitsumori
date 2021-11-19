<template>
<div>
    <span id="index">追加商品</span>
    <br>
    <span>
        <label for="item_code">商品コード</label>
        <input type="text" class="search_box" id="item_code"/>
        <input type="button" value="検索" id="search"/>
    </span>
    <span>
        <label for="item_name">商品名</label>
        <input type="text" class="search_box" id="item_name"/>
    </span>
    <br>
    <span>
        <label for="price">単価</label>
        <input type="text" class="search_box" id="price"/>
    </span>
    <span>
        <label for="quantity">数量</label>
        <input type="text" class="search_box" id="quantity"/>
    </span>
    <br>
    <span>
        <label for="total_price">金額</label>
        <input type="text" class="search_box" id="total_price"/>
    </span>
    <br>
    <span>
        <input type="button" value="見積に追加" id="add"/>
    </span>
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