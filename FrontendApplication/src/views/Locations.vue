<template>
  <div class="space-y-3">
    <div class=" container ml-5 mt-10">
    <p class="font-bold text-2xl ">Orte</p>
    </div>
<location-header></location-header>
<location-header></location-header>
<location-header></location-header>
<location-header></location-header>
  </div>
</template>

<script>
import LocationHeader from "@/components/LocationHeader";
export default {
  name: "LocationsOverview",
  components: {LocationHeader}
}
</script>

<style scoped>

</style>