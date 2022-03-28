
const state = () => {
    return {
        data: null
    }
};

const getters = {
    getStoreData(state) {
        return state.data
    }
};

const actions = {};
const mutations = {
    SET_DATA(state, payload) {
        state.data = payload;
    },
};

export default {
    namespaced: true,
    state,
    getters,
    actions,
    mutations,
};