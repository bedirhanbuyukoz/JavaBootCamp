import React from "react";
import { NavLink } from "react-router-dom";
import { Menu } from "semantic-ui-react";

export default function LeftSideBar() {
  return (
    <div>
      <Menu pointing vertical>
        <Menu.Item as={NavLink} to="/" name="Job Ads" />
        <Menu.Item as={NavLink} to="/employers" name="Employers" />
        <Menu.Item as={NavLink} to="/candidates" name="Candidates" />
      </Menu>
    </div>
  );
}
