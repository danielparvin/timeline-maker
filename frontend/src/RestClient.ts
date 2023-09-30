export class RestClient {
    static baseUrl = "http://localhost:8080";

    static async getTimeline(id: number) : Promise<any> {
        const url = `${RestClient.baseUrl}/timelines/${id}`;
        const response = await fetch(url);
        if (response.status !== 200) {
            return null;
        }
        return await response.json();
    }

    static addTimeline(timeline: any) : Promise<any> {
        const url = `${RestClient.baseUrl}/timelines`;
        return fetch(
                    url,
                    {
                        method: 'POST',
                        headers: { 'Content-Type': 'application/json' },
                        body: JSON.stringify(timeline)
                    }
        );
    }
}
