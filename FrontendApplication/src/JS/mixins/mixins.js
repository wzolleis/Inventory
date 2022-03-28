
export default  {
    methods: {
    registerStoreModule(moduleName, storeModule) {
        const store = this.$store;

        if (!(store && store.state && store.state[moduleName])) {
            store.registerModule('product/' + this.devkey.toString(), storeModule);
        }
    }
}}

