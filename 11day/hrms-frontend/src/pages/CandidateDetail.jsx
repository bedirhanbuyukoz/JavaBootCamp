import React, { useEffect, useState } from "react";
import { useParams } from "react-router";
import { Card, Button } from "semantic-ui-react";
import CandidateService from "../services/candidateService";

export default function CandidateDetail() {
  let { id } = useParams();

  const [candidate, setCandidate] = useState({});

  useEffect(() => {
    let candidateService = new CandidateService();
    candidateService
      .getCandidateById(id)
      .then((result) => setCandidate(result.data.data));
  }, [id]);

  return (
    <div>
      <Card.Group>
        <Card fluid>
          <Card.Content>
            <Card.Header>
              {candidate.firstName + " " + candidate.lastName}
            </Card.Header>
            <Card.Meta>{candidate.email}</Card.Meta>
            <Card.Description>{candidate.identityNumber}</Card.Description>
          </Card.Content>
          <Card.Content extra>
            <div className="ui two buttons">
              <Button basic color="red">
                Back
              </Button>
              <Button basic color="green">
                Contact
              </Button>
            </div>
          </Card.Content>
        </Card>
      </Card.Group>
    </div>
  );
}
