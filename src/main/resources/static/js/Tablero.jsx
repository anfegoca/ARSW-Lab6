class StatusComponent extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            error: null,
            isLoaded: false,
            status: ""
        };
    }
    static addPoint(mouseX,mouseY){
        const punto = new FormData();
        data.append('x', mouseX);
        data.append('y', mouseY);
    }
    componentDidMount() {
        this.timerID = setInterval(
                () => this.addpoint(),
                5000
                );
    }
    addpoint(){
        fetch("/add", punto)
        .then(data => this.setState({ postId: data.id }));
        
    }
    checkStatus() {
        fetch("/status")
                .then(res => res.json())
                .then(
                        (result) => {
                    this.setState({
                        isLoaded: true,
                        status: result.status
                    });
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
        const {error, isLoaded, status} = this.state;
            if (error) {
                return <div>Error: {error.message}</div>;
                    } else if (!isLoaded) {
                        return <div>Loading...</div>;
                    } else {
                        return (
                            <div> 
                                <h1>The server status is:</h1>
                                    <p>
                                        {status}
                                    </p>
                            </div>
                                );
                    }
            }
    }
ReactDOM.render(
    <StatusComponent />,
    document.getElementById('status')
);