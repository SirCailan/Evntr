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
            name: 'host',
            type: 'reference',
            to: [{ type: 'host' }]
        },
        {
            title: 'Speaker',
            name: 'speaker',
            type: 'reference',
            to: [{ type: 'speaker' }]
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
            type: 'image',
            fields: [
                {
                    title: 'Caption',
                    name: 'caption',
                    type: 'text',
                    options: {
                        isHighlighted: true
                    }
                }
            ],
            options: {
                hotspot: true,
            }
        },
        {
            title: 'Full Image',
            name: 'image',
            type: 'image',
            fields: [
                {
                    title: 'Caption',
                    name: 'caption',
                    type: 'text',
                    options: {
                        isHighlighted: true
                    }
                }
            ],
            options: {
                hotspot: true,
            }
        }
    ]
}