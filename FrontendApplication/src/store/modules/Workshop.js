const state = {
    jobs: null,
    devices: null
};

const getters = {
    getAllWorkshopJobs(state) {
        return state.jobs
    },
    getAllProducts(state) {
        return state.devices
    },
    getProductByID: (state) => (id) => {
        return state.devices.find(device => device.id === id)
    },
    getWsJobByID: (state) => (id) => {
        return state.jobs.find(device => device.id === id)
    }
};

const actions = {};

const mutations = {
    SET_WORKSHOP(state, payload) {
        state.jobs = payload;
    },
    SET_DEVICES(state, payload) {
        state.devices = payload;
    }
};

export default {
    state,
    getters,
    actions,
    mutations,
};