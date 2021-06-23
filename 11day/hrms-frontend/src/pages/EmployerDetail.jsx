import React, { useEffect, useState } from "react";
import { useParams } from "react-router";
import { Card, Button } from "semantic-ui-react";
import EmployerService from "../services/employerService";

export default function EmployerDetail() {
  let { id } = useParams();

  const [employer, setEmployer] = useState({});

  useEffect(() => {
    let employerService = new EmployerService();
    employerService
      .getEmployerById(id)
      .then((result) => setEmployer(result.data.data));
  }, [id]);

  return (
    <div>
      <Card.Group>
        <Card fluid>
          <Card.Content>
            <Card.Header>{employer.companyName}</Card.Header>
            <Card.Meta>{employer.email}</Card.Meta>
            <Card.Description>{employer.phoneNumber}</Card.Description>
          </Card.Content>
          <Card.Content extra>
            <div className="ui two buttons">
              <Button basic color="red">
                Back
              </Button>
              <Button basic color="green">
                Job Ads
              </Button>
            </div>
          </Card.Content>
        </Card>
      </Card.Group>
    </div>
  );
}
