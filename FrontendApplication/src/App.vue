<template>
  <navigation-element></navigation-element>
  <router-view/>
</template>
<script>
import NavigationElement from "@/components/NavigationElement";
export default {
  components: {NavigationElement}
}
</script>