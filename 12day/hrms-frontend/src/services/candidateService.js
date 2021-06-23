import axios from "axios";

export default class CandidateService {
  getCandidates() {
    return axios.get("http://localhost:8080/api/candidates/getall");
  }

  getCandidateById(id) {
    return axios.get("http://localhost:8080/api/candidates/getbyid?id=" + id);
  }
}
