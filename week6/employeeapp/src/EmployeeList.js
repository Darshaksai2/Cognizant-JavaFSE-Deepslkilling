import React, { Component } from 'react';

class EmployeeList extends Component {
  constructor(props) {
    super(props);
    this.state = {
      employees: [
        { id: 101, name: 'John Doe', designation: 'Developer', salary: 75000 },
        { id: 102, name: 'Jane Smith', designation: 'Designer', salary: 68000 },
        { id: 103, name: 'Bob Johnson', designation: 'Manager', salary: 90000 }
      ],
      selectedEmployee: null,
      showList: true
    };
  }

  toggleView = () => {
    this.setState((prevState) => ({ showList: !prevState.showList }));
  };

  selectEmployee = (emp) => {
    this.setState({ selectedEmployee: emp, showList: false });
  };

  render() {
    return (
      <div style={{ textAlign: 'center', marginTop: '40px' }}>
        <h2>Employee Directory</h2>
        <button onClick={this.toggleView} style={{ marginBottom: '20px', padding: '8px 16px' }}>
          {this.state.showList ? 'Hide List' : 'Show List'}
        </button>

        {this.state.showList ? (
          <table border="1" style={{ margin: '0 auto', width: '60%', textAlign: 'left' }}>
            <thead>
              <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Designation</th>
                <th>Action</th>
              </tr>
            </thead>
            <tbody>
              {this.state.employees.map((emp) => (
                <tr key={emp.id}>
                  <td>{emp.id}</td>
                  <td>{emp.name}</td>
                  <td>{emp.designation}</td>
                  <td>
                    <button onClick={() => this.selectEmployee(emp)}>View Details</button>
                  </td>
                </tr>
              ))}
            </tbody>
          </table>
        ) : this.state.selectedEmployee ? (
          <div style={{ border: '1px solid #ccc', padding: '20px', width: '300px', margin: '0 auto' }}>
            <h3>Employee Details</h3>
            <p><strong>ID:</strong> {this.state.selectedEmployee.id}</p>
            <p><strong>Name:</strong> {this.state.selectedEmployee.name}</p>
            <p><strong>Designation:</strong> {this.state.selectedEmployee.designation}</p>
            <p><strong>Salary:</strong> ${this.state.selectedEmployee.salary}</p>
          </div>
        ) : (
          <p>Click "Show List" to view employees.</p>
        )}
      </div>
    );
  }
}

export default EmployeeList;