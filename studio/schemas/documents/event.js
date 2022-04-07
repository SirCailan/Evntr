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
            type: 'string',
            validation: Rule => [
                Rule.required(),
                Rule.max(125).warning('Keep descriptions short and sweet')
            ]
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