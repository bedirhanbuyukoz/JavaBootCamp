import axios from "axios";

export default class JobAdService {
  getJobAds() {
    return axios.get(
      "http://localhost:8080/api/jobads/getJobAdsInDetailsSortedByDate"
    );
  }

  getJobAdsById(id) {
    return axios.get(
      "http://localhost:8080/api/jobads/getJobAdsInDetailsById?id=" + id
    );
  }
}
