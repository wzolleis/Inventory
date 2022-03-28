

const state = () => {
    return {
        jobs: null
    }
};

const getters = {
    getJobs(state) {
        return state.jobs

    }
};

const actions = {};

const mutations = {
    SET_JOBS(state, payload) {
        state.jobs = payload;
    },
    SET_JOB_INFORMATION(state, information, payload) {
        state.jobs[information] = payload;
    }
};

export default {
    namespaced: true,
    state,
    getters,
    actions,
    mutations,
};