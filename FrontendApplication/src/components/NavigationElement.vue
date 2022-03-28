<template>
<div class="mt-4 container ml-10 -mb-6">
  <div class="flex justify-content-between items-center">
    <div class=" flex justify-between underline  space-x-4 text-indigo-600 font-bold">
    <router-link to="/jobs" class="my-0">Jobs</router-link>
    <router-link to="/locations" class="my-0">Orte</router-link>
    <router-link to="/workshop" class="my-0">Werkstatt</router-link>
    <router-link to="/installations" class="my-0">Festinstallationen</router-link>
    </div>

<!--    <div class=" flex items-center bg-indigo-600 rounded-xl py-2 px-3">-->
<!--      <img src="@/assets/barcodew.png" class="max-h-8" alt="">-->
<!--    <router-link to="/" class="my-0 ml-3 text-white text-xs sm:text-sm font-bold">Scan</router-link>-->
<!--    </div>-->


  </div>





</div>
</template>

<script>
export default {
  name: "NavigationElement"
}
</script>

<style scoped>

</style>