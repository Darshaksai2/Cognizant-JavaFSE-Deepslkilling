import React from 'react';
import { mount, shallow } from 'enzyme';
import CohortDetails from './CohortDetails';
import { CohortData } from './Cohort';

describe('Cohort Details Component', () => {
  test('should create the component', () => {
    const wrapper = shallow(<CohortDetails cohort={CohortData[0]} />);
    expect(wrapper.exists()).toBe(true);
  });

  test('should initialize the props', () => {
    const testCohort = CohortData[0];
    const wrapper = mount(<CohortDetails cohort={testCohort} />);
    expect(wrapper.props().cohort).toEqual(testCohort);
  });

  test('should display cohort code in h3', () => {
    const testCohort = CohortData[0];
    const wrapper = mount(<CohortDetails cohort={testCohort} />);
    expect(wrapper.find('h3').text()).toContain(testCohort.cohortCode);
  });

  test('should always render same html', () => {
    const wrapper = shallow(<CohortDetails cohort={CohortData[0]} />);
    expect(wrapper).toMatchSnapshot();
  });
});