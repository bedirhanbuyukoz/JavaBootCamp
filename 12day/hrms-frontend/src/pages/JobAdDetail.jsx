import React, { useEffect, useState } from "react";
import { useParams } from "react-router";
import { Card, Button } from "semantic-ui-react";
import JobAdService from "../services/jobAdService";
import moment from "moment";

export default function JobAdDetail() {
  let { id } = useParams();

  const [jobAd, setjobAd] = useState({});

  useEffect(() => {
    let jobAdService = new JobAdService();
    jobAdService
      .getJobAdsById(id)
      .then((result) => setjobAd(result.data.data[0]));
  }, [id]);

  console.log(jobAd);

  return (
    <div>
      <Card.Group>
        <Card fluid>
          <Card.Content>
            <Card.Header>{jobAd.jobTitle}</Card.Header>
            <Card.Meta>{jobAd.companyName}</Card.Meta>
            <Card.Description>
              Deadline:
              {" " +
                moment(new Date(Date.parse(jobAd.deadline))).format(
                  "DD-MM-YYYY"
                )}
            </Card.Description>
          </Card.Content>
          <Card.Content extra>
            <div className="ui two buttons">
              <Button basic color="red">
                Back
              </Button>
              <Button basic color="green">
                Apply
              </Button>
            </div>
          </Card.Content>
        </Card>
      </Card.Group>
    </div>
  );
}
