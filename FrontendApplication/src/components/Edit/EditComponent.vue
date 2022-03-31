<template>
  <div class="container">
    <div class="mx-3 mt-10 space-y-3" v-if="loaded">


      <p class="font-bold text-2xl">Artikel bearbeiten</p>
      <div>
        <p class="my-0 text-gray-400 text-sm mb-2">Artikelname:</p>
        <input type="text" v-model="product.name" class=" w-full rounded bg-gray-200 p-2 font-bold">
      </div>

      <div class="grid grid-cols-2 gap-3">
        <div>
          <p class="my-0 text-gray-400 text-sm flex mb-1">Kategorie</p>
          <select @change="setCategory" name="Select" id="1" v-model=product.category.name
                  class="p-2 font-bold select rounded w-full bg-gray-200 border-none checked:bg-red-500 border-none">
            <option v-for="option in selection.categories" :key="option.length" class="">{{ option.name }}</option>
          </select>
        </div>
        <div>
          <p class="my-0 text-gray-400 text-sm flex mb-1">Position</p>
          <select @change="setPosition" name="Select" id="2" v-model=product.position.name
                  class="p-2 font-bold select rounded w-full bg-gray-200  border-none checked:bg-red-500 border-none">
            <option v-for="option in selection.positions" :key="option.id" class="font-bold">{{ option.name }}</option>
          </select>
        </div>
      </div>
      <div>
        <p class="my-0 text-gray-400 text-sm mb-2">Beschreibung:</p>
        <input type="text" v-model="product.description" class=" w-full rounded bg-gray-200 p-2 font-bold">
      </div>
      <div>
        <p class="my-0 text-gray-400 text-sm mb-2">Menge:</p>
        <input type="text" v-model="product.quantity" class="w-full rounded bg-gray-200 p-2 font-bold">
      </div>
      <div class="mt-3">
        <edit-buttons @save="saveProduct"></edit-buttons>
      </div>




    </div>

  </div>

</template>

<script>
import storeData from "@/JS/mixins/storeData";
import EditButtons from "@/components/Edit/EditButtons";
import store from "@/store";


export default {
  name: "ProductEditComponent",
  components: {EditButtons},
  mixins: [storeData],
  async created() {
    await this.storeData("product", this.$route.params.id);
    await this.storeData("options", "all");
    this.product = this.getData("product", this.$route.params.id)
    this.selection = this.getData("options", "all")
    this.loaded = true;
  },
  data() {
    return {
      loaded: false,
      product: null,
      selection: {
        categories: [],
        positions: []
      }


    }
  },
  methods: {
    setPosition() {
      let foundPosition = this.selection.positions.find(position => position.name === this.product.position.name)
      this.product.position = foundPosition;
    },
    setCategory(){
      let foundCategory = this.selection.categories.find (category => category.name === this.product.category.name)
      this.product.category = foundCategory
    },

    saveProduct(){
      store.commit(this.setData("product", this.$route.params.id), this.product)
      console.log(this.getData("product", this.$route.params.id));

    }


  }
}
</script>
