export default {
    title: 'Event',
    name: 'event',
    type: 'document',
    fields: [
        {
            title: 'Name of Event',
            name: 'name',
            type: 'string',
            validation: Rule => Rule.required(),
        },
        {
            title: 'Date',
            name: 'date',
            type: 'datetime',
            validation: Rule => Rule.required().min(new Date),

        },
        {
            title: 'Place / Venue',
            name: 'venue',
            type: 'string',
            validation: Rule => Rule.required(),
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
            type: 'string',
            validation: Rule => Rule.required(),
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