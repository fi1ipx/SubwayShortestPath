import React, { Component } from 'react';
import './App.css';
import 'react-table/react-table.css';

import Select from 'react-select';
import ReactTable from 'react-table'

class App extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            selectedOption1: null,
            selectedOption2: null,
            stations: null,
            error: null,
            options: [],
            isLoaded: false,
            pathIsLoaded: false,
            pathError: null,
            pathData: []
        };
    }

    handleChange1 = (selectedOption1) => {
        this.setState({ selectedOption1 });
        console.log(`Option selected1:`, selectedOption1);
        console.log(`Option selected2:`, this.state.selectedOption2);
        if (selectedOption1 != null && this.state.selectedOption2 != null) {
            this.getPath(selectedOption1.id, this.state.selectedOption2.id);
        }
    }
    handleChange2 = (selectedOption2) => {
        this.setState({ selectedOption2 });
        console.log(`Option selected1:`, this.state.selectedOption1);
        console.log(`Option selected2:`, selectedOption2);
        if (this.state.selectedOption1 != null && selectedOption2 != null) {
            this.getPath(this.state.selectedOption1.id, selectedOption2.id);
        }
    }

    getPath(selectedOption1, selectedOption2) {
        console.log(`Option selected1:`, selectedOption1);
        console.log(`Option selected2:`, selectedOption2);
        if (selectedOption1 != null && selectedOption2 != null) {
            var url = "/path?src=" + selectedOption1 + "&dst=" + selectedOption2;
            console.log('Getting path from ' + url);
            fetch(url)
                .then(res => res.json())
                .then(
                    (result) => {
                        this.setState({
                            pathIsLoaded: true,
                            pathData: result
                        });
                        console.log('Path fetched');
                        console.log(result);
                        function getLineClass(lineNum) {
                            return "sphere line" + lineNum;
                        }
                        result.forEach(function(a){
                            var lineNum = a.lineNum;
                            a.name = <span><div className={getLineClass(lineNum)}></div> {a.name}</span>;
                        });
                        this.setState({pathData: result});
                    },
                    // Note: it's important to handle errors here
                    // instead of a catch() block so that we don't swallow
                    // exceptions from actual bugs in components.
                    (error) => {
                        this.setState({
                            pathIsLoaded: true,
                            // pathError
                        });
                    }
                )
        }
    }

    componentWillMount() {
        fetch('/stations')
            .then(res => res.json())
            .then(
                (result) => {
                    this.setState({
                        isLoaded: true,
                        stations: result
                    });
                    console.log('stations fetched');
                    console.log(result);
                    var options = [];
                    function getLineClass(lineNum) {
                        return "sphere line" + lineNum;
                    }
                    result.forEach(function(a){
                        var newElement = {value: a.name, id: a.id, label: a.name};
                        var lineNum = a.lineNum;
                        newElement.label = <span><div className={getLineClass(lineNum)}></div> {a.name}</span>;
                        options.push(newElement);
                    });
                    this.setState({options: options});
                },
                // Note: it's important to handle errors here
                // instead of a catch() block so that we don't swallow
                // exceptions from actual bugs in components.
                (error) => {
                    this.setState({
                        isLoaded: true,
                        error
                    });
                }
            )
    }

    render() {
        const { selectedOption1, selectedOption2, isLoaded,
            error, options ,pathIsLoaded, pathError, pathData } = this.state

        const columns = [{
            Header: 'Station id',
            accessor: 'id', // String-based value accessors!
            sortable: false, // use table default
            resizable: false, // use table default
            filterable: false, // use table default
            show: true
        }, {
            Header: 'Station name',
            accessor: 'name',
            sortable: false, // use table default
            resizable: false, // use table default
            filterable: false, // use table default
            show: true
        }, {
            Header: 'Line', // Required because our accessor is not a string
            accessor: 'lineNum',
            sortable: false, // use table default
            resizable: false, // use table default
            filterable: false, // use table default
            show: true
        }];

        return (
            <div align="center">
                <br/><br/><br/>
                <div className="select">
                    <Select
                        value={selectedOption1}
                        onChange={this.handleChange1}
                        options={options}
                    />
                </div>
                <div id="middlediv" dangerouslySetInnerHTML={{__html: '&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;'}} />
                <div className="select">
                    <Select
                        value={selectedOption2}
                        onChange={this.handleChange2}
                        options={options}
                    />
                </div>
                <br/><br/><br/><br/>
                <div id="pathtable">
                    <ReactTable
                        data={pathData}
                        columns={columns}
                        defaultPageSize={100}
                        minRows={3}
                    />
                </div>
            </div>
        );
    }
}
export default App;
