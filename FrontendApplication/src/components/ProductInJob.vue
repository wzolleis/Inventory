<template>
<div v-if="loaded">
  <div class="flex items-center bg-white shadow shadow-lg rounded-xl py-3">
  <img :src="$store.getters['ProductInformation/getProductData'].imageURL" class="max-h-14" alt="">
    <div class="ml-3">
      <p class="font-bold my-0">{{ $store.getters['ProductInformation/getProductData'].name }}</p>
      <p class="text-gray-400  text-sm my-0"> SN: <strong>{{ $store.getters['ProductInformation/getProductData'].sn }}</strong></p>
      <p class="text-gray-400 text-sm my-0">IN: <strong>{{ $store.getters['ProductInformation/getProductData'].inventoryNumber }}</strong></p>
    </div>
    <button @click="click" class="bg-indigo-600 rounded-xl  my-1 px-3 shadow shadow-indigo-500 shadow-sm py-2 ml-auto mr-3 font-bold text-white">Ansehen</button>
  </div>



</div>
</template>

<script>
import store from "@/store";

export default {
  name: "ProductInJob",
  data(){
    return{
      loaded:  false,
      product: Object,
    }
  },
  async beforeCreate() {


  },
  methods:{
    click(){
      this.$router.push("/product/" + store.getters.getProductData.id)
    }


  }
}
</script>

<style scoped>

</style>