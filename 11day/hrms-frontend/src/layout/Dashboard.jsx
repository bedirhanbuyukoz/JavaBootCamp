import React from "react";
import Footer from "./Footer";
import LeftSideBar from "./LeftSideBar";
import { Grid } from "semantic-ui-react";
import { Route } from "react-router";
import JobAdList from "../pages/JobAdList";
import EmployerList from "../pages/EmployerList";
import JobAdDetail from "../pages/JobAdDetail";
import CandidateList from "../pages/CandidateList";
import CandidateDetail from "../pages/CandidateDetail";
import EmployerDetail from "../pages/EmployerDetail";
import CreateJobAd from "../pages/CreateJobAd";
import CreateCV from "../pages/CreateCV";

export default function Dashboard() {
  return (
    <div>
      <Grid>
        <Grid.Row>
          <Grid.Column width={4}>
            <LeftSideBar />
          </Grid.Column>
          <Grid.Column width={12}>
            <Route exact path="/" component={JobAdList} />
            <Route exact path="/jobads" component={JobAdList} />
            <Route exact path="/jobads/:id" component={JobAdDetail} />
            <Route exact path="/createJobAd" component={CreateJobAd} />
            <Route exact path="/employers" component={EmployerList} />
            <Route exact path="/employers/:id" component={EmployerDetail} />
            <Route exact path="/candidates" component={CandidateList} />
            <Route exact path="/candidates/:id" component={CandidateDetail} />
            <Route exact path="/createCv" component={CreateCV} />
          </Grid.Column>
        </Grid.Row>
      </Grid>

      <Footer />
    </div>
  );
}
