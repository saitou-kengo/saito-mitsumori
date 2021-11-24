<template>
<div>
    <span id="index">追加商品</span>
    <br>
    <span>
        <label for="item_code">商品コード</label>
        <input v-model="productCd" type="text"/>
        <input type="button" value="検索" id="search"/>
    </span>
    <span>
        <label for="item_name">商品名</label>
        <input v-model="productName" type="text"/>
    </span>
    <br>
    <span>
        <label for="price">単価</label>
        <input v-model="price" type="text"/>
    </span>
    <span>
        <label for="quantity">数量</label>
        <input v-model="quantity" type="text"/>
    </span>
    <br>
    <span>
        <label for="total_price">金額</label>
        <input v-model="totalPrice" type="text"/>
    </span>
    <br>
    <span>
        <input type="button" value="見積に追加" id="add"/>
    </span>
</div>
</template>

<script>
import axios from 'axios'

export default {
    data() {
        return {
            productCd: "",
            productName: "",
            price: "",
            quantity: "",
            totalPrice: ""
        }
    },
    methods: {
        insertDetail: function() {
            axios
            .post("/api/v1/estimate-details", {
                productCd: this.productCd,
                quantity: this.quantity
            })
            .then((res) => {
                console.log(res);
            })
            .catch((err) => {
                console.log("エラー：" + err);
            })
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