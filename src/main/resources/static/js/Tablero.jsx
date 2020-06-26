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
        //console.log("HOLA");
        const punto = new FormData();
        punto.append('x', mouseX);
        punto.append('y', mouseY);
        fetch("/addPoint",{
        method: 'post',
        body: punto
        }).then(response => {
          //console.log("punto enviado")
        }).catch(err => {
          console.log(err)
        })  
      }
    
    componentDidMount() {
        this.timerID = setInterval(
                () => this.verificar(),
                10
                );
    }
    verificar(){
        fetch("/vacio").then(res => res.json()).then((result) => {
            if(!result){
                this.getpoints()
            }
            });
        
    }
    getpoints() {
     //console.log("punto get");
    fetch("/getPoint")
      .then(res => res.json())
      .then(
        (result) => {
          this.setState({
              
            isLoaded: true,
            status: "Dibujando"
            
            //items: result.items
          });
          dibujo(result);
        },
        // Nota: es importante manejar errores aquí y no en 
        // un bloque catch() para que no interceptemos errores
        // de errores reales en los componentes.
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
                        return <div>Ya puede dibujar...</div>;
                    } else {
                        return (
                            <div> 
                                <h1>Tablero:</h1>
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