import { RestClient } from '../../RestClient';

export default function TimelineMaker() {
    const handleSubmit = (e: any) => {
    		e.preventDefault();
    		let timeline = {
    			name:  (document.getElementById('name') as HTMLInputElement).value
    			// TODO Add event field here.
    		}
    		RestClient.addTimeline(timeline)
    		          .then( () => {

    		            // TODO Redirect to new timeline page here.
    				  })
    				  .catch(err => alert(err))
    	}

    return(
        <>
            <h2>Add Timeline</h2>
            <form onSubmit={handleSubmit}>
                <p>
                    <label htmlFor='name'>Name</label>
                    <input id='name'/>
                </p>
                {/* TODO Add event fields here.*/}
                <p>
                    <label>&nbsp;</label> {/* Placeholder */}
                    <button>Submit</button>
                </p>
            </form>
        </>
    )
}