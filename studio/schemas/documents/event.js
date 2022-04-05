export default {
    title: 'Event',
    name: 'event',
    type: 'document',
    fields: [
        {
            title: 'Name of Event',
            name: 'name',
            type: 'string'
        },
        {
            title: 'Date',
            name: 'date',
            type: 'date'
        },
        {
            title: 'Place / Venue',
            name: 'venue',
            type: 'string'
        },
        {
            title: 'Host',
            description: 'Company or Hosted by:',
            name: 'host',
            type: 'string'
        },
        {
            title: 'Category / Type of event',
            name: 'category',
            type: 'string'
        },
        {
            title: 'Header',
            description: 'Short description about event',
            name: 'header',
            type: 'string'
        },
        {
            title: 'Description',
            description: 'Longer text about event',
            name: 'text',
            type: 'text'
        },
        {
            title: 'Price',
            name: 'price',
            type: 'string'
        },
        {
            title: 'Age limit',
            name: 'age',
            type: 'string'
        },
        {
            title: 'Cover Image',
            name: 'cover',
            type: 'image'
        },
        {
            title: 'Full Image',
            name: 'image',
            type: 'image'
        }
    ]
}